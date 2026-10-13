package chocobe

import chocobe.global.bean.SingletonScope

class WiseSayingService(
    val wiseSayingMemoryRepository: WiseSayingMemoryRepository = SingletonScope.wiseSayingMemoryRepository
) {

    fun add(content: String, author: String): WiseSaying = WiseSaying(
        content = content,
        author = author
    ).also {
        wiseSayingMemoryRepository.save(it)
    }

    fun findListDesc(): List<WiseSaying> = wiseSayingMemoryRepository.findListDesc()
    fun findById(id: Int): WiseSaying? = wiseSayingMemoryRepository.findById(id)
    fun delete(wiseSaying: WiseSaying) = wiseSayingMemoryRepository.delete(wiseSaying)
}