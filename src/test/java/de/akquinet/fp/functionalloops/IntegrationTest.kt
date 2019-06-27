package de.akquinet.fp.functionalloops

import org.junit.jupiter.api.Test
import kotlin.math.absoluteValue
import kotlin.test.assertTrue

internal class IntegrationTest {

    @Test
    fun integrateImperative() {
        testIntegrationFunction(::integrateImperative)
    }

    @Test
    fun integrateFunctional() {
        testIntegrationFunction(::integrateFunctional)
    }

    @Test
    fun integrateFunctionalSequence() {
        testIntegrationFunction(::integrateFunctionalSequence)
    }

    @Test
    fun integrateFunctionalSequence2() {
        testIntegrationFunction(::integrateFunctionalSequence2)
    }

    private val iterations = 100

    private fun testIntegrationFunction(integrationF: IntegrationType) {
        println("$Int.MAX_VALUE $iterations ${Int.MAX_VALUE-iterations} " + Int.MAX_VALUE)

        val const1: (Double) -> Double = { _ -> 1.0 }
        //assertNearlyEquals(1.0, integrationF(0.0, 1.0, iterations, const1))
        //assertNearlyEquals(1.0, integrationF(0.0, 1.0, iterations *1, const1))
        assertNearlyEquals(2.0, integrationF(-1.0, 1.0, iterations, const1))
    }

    fun assertNearlyEquals( expected : Double, actual : Double) {
        val allowedError = 0.001
        val delta = (expected - actual).absoluteValue
        val message = "expected $expected differs from actual $actual, delta is $delta"
        assertTrue(delta < allowedError, message)
    }
}
