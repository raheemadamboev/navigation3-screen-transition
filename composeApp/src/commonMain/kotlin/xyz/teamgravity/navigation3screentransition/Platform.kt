package xyz.teamgravity.navigation3screentransition

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform