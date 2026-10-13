package chocobe

import chocobe.global.bean.SingletonScope

class WiseSayingService(
    val wiseSayingRepository: WiseSayingRepository = SingletonScope.wiseSayingFileRepository
) {

    fun add(content: String, author: String): WiseSaying = WiseSaying(
        content = content,
        author = author
    ).also {
        wiseSayingRepository.save(it)
    }

    fun findByKeyword(keywordType: String, keyword: String): List<WiseSaying> {
        return when (keywordType) {
            "author" -> wiseSayingRepository.findByAuthorLike("%$keyword%")
            "content" -> wiseSayingRepository.findByContentLike("%$keyword%")
            else -> wiseSayingRepository.findByAuthorContent("%$keyword%")
        }
    }

    fun findListDesc(): List<WiseSaying> = wiseSayingRepository.findListDesc()
    fun findById(id: Int): WiseSaying? = wiseSayingRepository.findById(id)
    fun delete(wiseSaying: WiseSaying) = wiseSayingRepository.delete(wiseSaying)

    fun findByKeywordPaged(keywordType: String, keyword: String, itemsPerPage: Int, pageNo: Int): Page<WiseSaying> {
        return wiseSayingRepository.findByKeywordPaged(keywordType, keyword, itemsPerPage, pageNo)
    }

    fun findAllPaged(itemsPerPage: Int, pageNo: Int): Page<WiseSaying> {
        return wiseSayingRepository.findAllPaged(itemsPerPage, pageNo)
    }
}

