package dev.tmsoft.lib.filter

import dev.tmsoft.lib.exposed.Currency
import dev.tmsoft.lib.exposed.Money
import dev.tmsoft.lib.exposed.money
import java.time.LocalDate
import kotlin.test.assertTrue
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.JoinType
import org.jetbrains.exposed.sql.OrOp
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.`java-time`.date
import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.jupiter.api.Test

class FilterTest {
    @Test
    fun `simple query`() {
        val database = Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver", user = "root", password = "")
        transaction(database) {
            SchemaUtils.create(UserTable)
            val money = Money(10, Currency("EUR"))
            UserTable.insert {
                it[name] = "test"
                it[number] = 1
                it[balance] = money
                it[modifyAt] = LocalDate.now()
            }

            val query = UserTable.selectAll()
                .filter(
                    UserFilter,
                    PathValues(
                        mapOf(
                            "full_name" to listOf(SingleValue("Test"), SingleValue("Test2")),
                            "number" to listOf(RangeValue("1", null)),
                            "custom" to listOf(RangeValue("2021-12-12", null)),
                            "join" to listOf(RangeValue("address", null)),
                            "modify_at" to listOf(RangeValue("2021-11-11", "2021-11-12"))
                        )
                    )
                )
            assertTrue(
                query.prepareSQL(this)
                    .contains("((LOWER(\"USER\".FULL_NAME) LIKE ?) OR (LOWER(\"USER\".FULL_NAME) LIKE ?)) AND (\"USER\".\"NUMBER\" >= ?) AND (\"USER\".MODIFY_AT >= ?) AND ((LOWER(PROFILE.ADDRESS) LIKE ?)) AND (\"USER\".MODIFY_AT >= ?) AND (\"USER\".MODIFY_AT <= ?)")
            )
        }
    }
}

object UserFilter : Filter(UserTable) {
    val name = add("full_name")
    val number = add("number")
    val custom = add("custom", UserTable.modifyAt)
    val join = add("join", ProfileTable.address) { values ->
        addJoin {
            join(
                ProfileTable,
                JoinType.LEFT,
                ProfileTable.user,
                UserTable.id
            )
        }.andWhere { OrOp(values.map { it.op(ProfileTable.address) }) }
    }
    val modifyAt = add("modify_at")
}

object UserTable : IntIdTable() {
    val name = varchar("full_name", 255)
    val number = integer("number")
    val balance = money()
    val modifyAt = date("modify_at").default(LocalDate.now())
}

object ProfileTable : IntIdTable() {
    val user = reference("user", UserTable)
    val address = varchar("address", 255)
    val phone = varchar("phone", 255)
}