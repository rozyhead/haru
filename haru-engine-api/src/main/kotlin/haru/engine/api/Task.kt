package haru.engine.api

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * @author takeshi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class Task(
    val name: String
)
