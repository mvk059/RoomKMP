package fyi.manpreet.roomkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform