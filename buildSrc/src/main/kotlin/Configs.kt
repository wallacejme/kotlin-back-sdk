object Versions {
    const val h2database = "1.4.200"
    const val kotlin = "1.5.10"
    const val ktor = "1.6.0"
    const val junit = "5.7.1"
    const val test_logger = "3.0.0"
    const val postgresqlJDBC = "42.2.20"
    const val google_guice = "5.0.1"
    const val valiktor_core = "0.12.0"
    const val logback_classic = "1.3.0-alpha5"
    const val rabbitmq_amqp_client = "5.12.0"
    const val ktlint_gradle = "10.0.0"
    const val exposed = "0.31.1"
    const val mockito = "2.2.0"
    const val s3 = "2.16.57"
    const val kotlin_serialization_json = "1.2.1"
    const val embedded_postgres = "0.13.3"
    const val swagger_webjar = "3.34.0"
}

object Deps {
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val ktor_locations = "io.ktor:ktor-locations:${Versions.ktor}"
    const val ktor_server_test_host = "io.ktor:ktor-server-test-host:${Versions.ktor}"
    const val ktor_server_core = "io.ktor:ktor-server-core:${Versions.ktor}"
    const val ktor_client_serialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    const val ktor_auth_jwt = "io.ktor:ktor-auth-jwt:${Versions.ktor}"
    const val postgresqlJDBC = "org.postgresql:postgresql:${Versions.postgresqlJDBC}"
    const val google_guice = "com.google.inject:guice:${Versions.google_guice}"
    const val rabbitmq_amqp_client = "com.rabbitmq:amqp-client:${Versions.rabbitmq_amqp_client}"
    const val valiktor_core = "org.valiktor:valiktor-core:${Versions.valiktor_core}"
    const val logback_classic = "ch.qos.logback:logback-classic:${Versions.logback_classic}"
    const val junit_jupiter_engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    const val mockito = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito}"
    const val exposed_core = "org.jetbrains.exposed:exposed-core:${Versions.exposed}"
    const val exposed_dao = "org.jetbrains.exposed:exposed-dao:${Versions.exposed}"
    const val exposed_jdbc = "org.jetbrains.exposed:exposed-jdbc:${Versions.exposed}"
    const val kotlin_serialization_json = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlin_serialization_json}"
    const val exposed_time = "org.jetbrains.exposed:exposed-java-time:${Versions.exposed}"
    const val h2_database = "com.h2database:h2:${Versions.h2database}"
    const val s3 = "software.amazon.awssdk:s3:${Versions.s3}"
    const val kotlin_test = "org.jetbrains.kotlin:kotlin-test-junit5:${Versions.kotlin}"
    const val embedded_postgres = "com.opentable.components:otj-pg-embedded:${Versions.embedded_postgres}"
    const val junit_jupiter_api = "org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    const val swagger_webjar = "org.webjars:swagger-ui:${Versions.swagger_webjar}"
    const val ktor_webjar = "io.ktor:ktor-webjars:${Versions.ktor}"
}

object Plugins {
    const val test_logger = "com.adarshr.test-logger"
    const val ktlint_gradle = "org.jlleitschuh.gradle.ktlint"
    const val kotlin_serialization = "plugin.serialization"
}

object KotlinModules {
    const val jvm = "jvm"
}