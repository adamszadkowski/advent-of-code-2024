package info.szadkowski.adventofcode2024

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.math.abs

class Day1Test {
    private val input = Day1Test::class.java.classLoader.getResource("day1.txt").readText()
    private lateinit var listA: List<Int>
    private lateinit var listB: List<Int>

    @BeforeEach
    fun `prepare input`() {
        val listA = mutableListOf<Int>()
        val listB = mutableListOf<Int>()

        for (line in input.split("\n")) {
            val (a, b) = "(\\d+).*?(\\d+)".toRegex().find(line)!!.destructured
            listA += a.toInt()
            listB += b.toInt()
        }

        this.listA = listA
        this.listB = listB
    }

    @Test
    fun part1() {
        val result = listA.sorted()
            .zip(listB.sorted())
            .sumOf { (a, b) -> abs(a - b) }

        expectThat(result).isEqualTo(1765812)
    }

    @Test
    fun part2() {
        val bToCount = listB.groupingBy { it }.eachCount()

        var result = 0
        for (a in listA) {
            result += a * bToCount.getOrDefault(a, 0)
        }

        expectThat(result).isEqualTo(20520794)
    }
}