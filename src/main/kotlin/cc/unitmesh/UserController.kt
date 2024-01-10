package cc.unitmesh

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController() {
    @GetMapping
    fun getUsers(): UserDTO {
        return UserDTO(1L, "username", "email", "name", "surname")
    }
}

data class UserDTO(
    val id: Long? = null,
    val username: String,
    val email: String,
    val name: String,
    val surname: String? = null,
)