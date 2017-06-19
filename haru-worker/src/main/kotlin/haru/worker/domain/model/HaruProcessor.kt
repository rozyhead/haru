package haru.worker.domain.model

interface HaruProcessor {

  @Throws(HaruProcessorException::class)
  operator fun invoke(arguments: HaruProcessorArguments): HaruProcessorResult

}