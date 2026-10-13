package chocobe

class WiseSayingMemoryRepository : WiseSayingRepository {

    var lastId = 0
    val wiseSayings = mutableListOf<WiseSaying>()

    override
    fun save(wiseSaying: WiseSaying): WiseSaying {

//        if(wiseSaying.isNew()) {
//            wiseSaying.id = ++lastId
//            wiseSayings.add(wiseSaying)
//        }
//
//        return wiseSaying

        return wiseSaying
            .takeIf { it.isNew() }
            ?.also {
                wiseSaying.id = ++lastId
                wiseSayings.add(wiseSaying)
            } ?: wiseSaying
    }

    override
    fun findListDesc() = wiseSayings.reversed()

    override
    fun findById(id: Int): WiseSaying? = wiseSayings.firstOrNull { it.id == id }

    override fun findByAuthorLike(keyword: String): List<WiseSaying> {
        return listOf()
    }

    override fun findByContentLike(contentLike: String): List<WiseSaying> {
        TODO("Not yet implemented")
    }

    override fun findByAuthorContent(keyword: String): List<WiseSaying> {
        return listOf()
    }

    override
    fun delete(wiseSaying: WiseSaying) = wiseSayings.remove(wiseSaying)

    override
    fun clear() {
        wiseSayings.clear()
        lastId = 0
    }
}