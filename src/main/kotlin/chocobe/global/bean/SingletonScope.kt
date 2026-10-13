package chocobe.global.bean

import chocobe.SystemController
import chocobe.WiseSayingController
import chocobe.WiseSayingMemoryRepository
import chocobe.WiseSayingService

object SingletonScope {

    val wiseSayingMemoryRepository by lazy { WiseSayingMemoryRepository() }
    val wiseSayingService by lazy { WiseSayingService(wiseSayingMemoryRepository) }
    val wiseSayingController by lazy { WiseSayingController(wiseSayingService) }
    val systemController by lazy { SystemController() }

}