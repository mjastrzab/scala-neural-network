package nnetworks

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class NetworkTestSuite extends FunSuite {

    test("Test AND network implemented") {
    val weights: Array[Array[Double]] = Array(Array(-30.0), Array(20), Array(20))
    val layer = new Layer(weights)

    assert(layer.applyInputs(Array(1., 0., 0.)) === Array(-30.))
    assert(layer.applyInputs(Array(1., 0., 1.)) === Array(-10.))
    assert(layer.applyInputs(Array(1., 1., 0.)) === Array(-10.))
    assert(layer.applyInputs(Array(1., 1., 1.)) === Array(10.))

  }

  
  test("Test AND network implemented with activation function") {
    val weights: Array[Array[Double]] = Array(Array(-30.0), Array(20), Array(20))
    val layer = new Layer(weights)

    assert(layer.applyInputs(Array(1., 0., 0.),Functions.roundedSigmoid ) === Array(0))
    assert(layer.applyInputs(Array(1., 0., 1.), Functions.roundedSigmoid) === Array(0))
    assert(layer.applyInputs(Array(1., 1., 0.), Functions.roundedSigmoid) === Array(0))
    assert(layer.applyInputs(Array(1., 1., 1.), Functions.roundedSigmoid) === Array(1))

  }

  test("Test XOR network implemented") {
    val weights: Array[Array[Double]] = Array(Array(-30.0, 10.), Array(20, -20.), Array(20, -10.))
    val layer = new Layer(weights)

    assert(layer.applyInputs(Array(1., 0., 0.), Functions.roundedSigmoid) === Array(0, 1))
    assert(layer.applyInputs(Array(1., 0., 1.), Functions.roundedSigmoid) === Array(0, 1))
    assert(layer.applyInputs(Array(1., 1., 0.),Functions.roundedSigmoid) === Array(0, 0))
    assert(layer.applyInputs(Array(1., 1., 1.), Functions.roundedSigmoid) === Array(1, 0))

  }
  
  test("Test sigmoid funciton"){
    assert(Functions.roundedSigmoid(-4) === 0)
    assert(Functions.roundedSigmoid(-1) === 0)
    assert(Functions.roundedSigmoid(0) === 1)
    assert(Functions.roundedSigmoid(1) === 1)
    assert(Functions.roundedSigmoid(4) === 1)
  }

}
