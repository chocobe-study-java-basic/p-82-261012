package chocobe.global.bean

import chocobe.SystemController
import chocobe.WiseSayingController
import chocobe.WiseSayingFileRepository
import chocobe.WiseSayingMemoryRepository
import chocobe.WiseSayingService

object SingletonScope {

//    val wiseSayingMemoryRepository by lazy { WiseSayingMemoryRepository() }
    val wiseSayingFileRepository by lazy { WiseSayingFileRepository() }
//    val wiseSayingService by lazy { WiseSayingService(wiseSayingMemoryRepository) }
val wiseSayingService by lazy { WiseSayingService(wiseSayingFileRepository) }
    val wiseSayingController by lazy { WiseSayingController(wiseSayingService) }
    val systemController by lazy { SystemController() }

}