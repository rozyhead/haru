package haru.worker.domain.model.plugin

interface TaskProcessorPluginRegistry {

  fun register(plugin: TaskProcessorPlugin)

  fun unregister(pluginId: TaskProcessorPluginId)

  fun findById(pluginId: TaskProcessorPluginId): TaskProcessorPlugin

}