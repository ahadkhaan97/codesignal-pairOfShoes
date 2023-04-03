fun main() {
    print(
        solution(
            mutableListOf(
                mutableListOf(0, 21),
                mutableListOf(1, 23),
                mutableListOf(1, 21),
                mutableListOf(1, 23)
            )
        )
    )
}

fun solution(shoes: MutableList<MutableList<Int>>): Boolean {
    val leftShoes = mutableMapOf<Int, Int>()
    val rightShoes = mutableMapOf<Int, Int>()

    for (shoe in shoes) {
        val type = shoe[0]
        val size = shoe[1]

        if (type == 0) {
            leftShoes[size] = leftShoes.getOrDefault(size, 0) + 1
        } else {
            rightShoes[size] = rightShoes.getOrDefault(size, 0) + 1
        }
    }

    for ((size, count) in leftShoes) {
        if (count != rightShoes.getOrDefault(size, 0)) {
            return false
        }
    }

    for ((size, count) in rightShoes) {
        if (count != leftShoes.getOrDefault(size, 0)) {
            return false
        }
    }

    return true
}
