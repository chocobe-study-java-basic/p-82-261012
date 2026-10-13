package chocobe

interface WiseSayingRepository {
    fun save(wiseSaying: WiseSaying): WiseSaying
    fun findListDesc(): List<WiseSaying>
    fun findById(id: Int): WiseSaying?
    fun findByAuthorLike(authorLike: String): List<WiseSaying>
    fun findByContentLike(contentLike: String): List<WiseSaying>
    fun findByAuthorContent(contentLike: String): List<WiseSaying>
    fun findByKeywordPaged(keywordType: String, keyword: String, itemsPerPage: Int, pageNo: Int): Page<WiseSaying>
    fun findAllPaged(itemsPerPage: Int, pageNo: Int): Page<WiseSaying>
    fun delete(wiseSaying: WiseSaying): Boolean

    fun clear()
}