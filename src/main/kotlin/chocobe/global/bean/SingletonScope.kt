package chocobe.global.bean

import chocobe.SystemController
import chocobe.WiseSayingController
import chocobe.WiseSayingRepository
import chocobe.WiseSayingService

object SingletonScope {

    val wiseSayingRepository by lazy { WiseSayingRepository() }
    val wiseSayingService by lazy { WiseSayingService(wiseSayingRepository) }
    val wiseSayingController by lazy { WiseSayingController(wiseSayingService) }
    val systemController by lazy { SystemController() }

}