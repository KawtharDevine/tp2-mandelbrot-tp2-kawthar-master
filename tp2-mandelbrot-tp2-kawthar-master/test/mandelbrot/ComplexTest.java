package mandelbrot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexTest {
    private final Complex onePlusI = new Complex(1,1);
    private final Complex minusI = new Complex(0,-1);
    private final Complex minusOne = new Complex(-1,0);
    private final Complex oneMinusI = new Complex(1, -1);
    private final Complex twoI = new Complex(0,2);
    private final Complex two = new Complex(2,0);
    private final double real = -12;
    private final double imaginary = 10;


    @Test
    void testConstructor(){
        assertEquals(0., twoI.getReal(), Helpers.EPSILON);
        assertEquals(2., twoI.getImaginary(), Helpers.EPSILON);
        assertEquals(1., oneMinusI.getReal(), Helpers.EPSILON);
        assertEquals(-1., oneMinusI.getImaginary(), Helpers.EPSILON);
        assertEquals(2., two.getReal(), Helpers.EPSILON);
        assertEquals(0., two.getImaginary(), Helpers.EPSILON);
    }

    @Test
    void testGetReal(){
        assertEquals(2., two.getReal(), Helpers.EPSILON);
        assertEquals(1., oneMinusI.getReal(), Helpers.EPSILON);
        assertEquals(-1., new Complex(-1,1).getReal(), Helpers.EPSILON);
        assertEquals(real, new Complex(real, imaginary).getReal(), Helpers.EPSILON);
    }

    @Test
    void testGetImaginary(){
        assertEquals(2., twoI.getImaginary(), Helpers.EPSILON);
        assertEquals(1., new Complex(-1, 1).getImaginary(), Helpers.EPSILON);
        assertEquals(-1., oneMinusI.getImaginary(), Helpers.EPSILON);
        assertEquals(imaginary, new Complex(real, imaginary).getImaginary(), Helpers.EPSILON);
    }

    @Test
    void testOne(){
        assertEquals(1., Complex.ONE.getReal());
        assertEquals(0., Complex.ONE.getImaginary());
    }

    @Test
    void testI(){
        assertEquals(0, Complex.I.getReal());
        assertEquals(1, Complex.I.getImaginary());
    }

    @Test
    void testZero(){
        assertEquals(0, Complex.ZERO.getReal());
        assertEquals(0, Complex.ZERO.getImaginary());
    }

    @Test
    void testNegate(){
        assertEquals(minusOne, Complex.ONE.negate());
        assertEquals(Complex.I, minusI.negate());
        assertEquals(new Complex(-1, 1), oneMinusI.negate());
        assertEquals(new Complex(real, imaginary), new Complex(-real,-imaginary).negate());
    }

    @Test
    void testReciprocal(){
        assertEquals(Complex.ONE, Complex.ONE.reciprocal());
        assertEquals(Complex.I, minusI.reciprocal());
        assertEquals(new Complex(0.5,0), two.reciprocal());
        assertEquals(new Complex(0.5,0.5), oneMinusI.reciprocal());
    }

    @Test
    void testReciprocalOfZero(){
        assertThrows(ArithmeticException.class, ()->Complex.ZERO.reciprocal());
    }

    @Test
    void testSubstract(){
        assertEquals(minusOne, Complex.ZERO.subtract(Complex.ONE));
        assertEquals(oneMinusI, Complex.ONE.subtract(Complex.I));
        assertEquals(new Complex(real-1,imaginary-1),
                new Complex(real, imaginary).subtract(onePlusI));
    }

    @Test
    void testDivide(){
        assertEquals(onePlusI, onePlusI.divide(Complex.ONE));
        assertEquals(new Complex(0.5, 0), Complex.ONE.divide(two));
        assertEquals(minusI,oneMinusI.divide(onePlusI));
    }

    @Test
    void testDivideByZero(){
        assertThrows(ArithmeticException.class, ()->Complex.ONE.divide(Complex.ZERO));
    }

    @Test
    void testConjugate(){
        assertEquals(Complex.ZERO, Complex.ZERO.conjugate());
        assertEquals(Complex.ONE, Complex.ONE.conjugate());
        assertEquals(onePlusI, oneMinusI.conjugate());
        assertEquals(new Complex(real, -imaginary), new Complex(real, imaginary).conjugate());
    }

    @Test
    void testRotation(){
        assertEquals(Complex.I, Complex.rotation(Math.PI/2));
        assertEquals(minusI, Complex.rotation(-Math.PI/2));
        assertEquals(Complex.ONE, Complex.rotation(0));
        assertEquals(new Complex(Math.sqrt(2)/2., Math.sqrt(2)/2.),
                Complex.rotation(Math.PI/4));
        assertEquals(new Complex(1./2., Math.sqrt(3)/2.),
                Complex.rotation(Math.PI/3));
    }

    @Test
    void testToString(){
        assertEquals("1.0 - 1.0i", oneMinusI.toString());
        assertEquals("1.0 + 1.0i", onePlusI.toString());
        assertEquals("-1.0i", minusI.toString());
        assertEquals("2.0i", twoI.toString());
        assertEquals("2.0", two.toString());
    }

    @Test
    void testReal(){
        assertEquals(Complex.ONE, Complex.real(Complex.ONE.getReal()));
        assertEquals(minusOne, Complex.real(minusOne.getReal()));
        assertEquals(two, Complex.real(two.getReal()));
        assertEquals(new Complex(real, 0), Complex.real(real));
    }

    @Test
    void testAdd(){
        assertEquals(Complex.ONE, Complex.ZERO.add(Complex.ONE));
        assertEquals(onePlusI, Complex.ONE.add(Complex.I));
        assertEquals(new Complex(real+1, imaginary+1), new Complex(real, imaginary).add(onePlusI));
    }

    @Test
    void testMultiply(){
        assertEquals(Complex.I, Complex.I.multiply(Complex.ONE));
        assertEquals(minusOne, Complex.I.multiply(Complex.I));
        assertEquals(minusOne, Complex.ONE.multiply(minusOne));
        assertEquals(Complex.ONE, Complex.I.multiply(minusI));
        assertEquals(Complex.ONE, Complex.ONE.multiply(Complex.ONE));
        assertEquals(minusI, minusOne.multiply(Complex.I));
        assertEquals(minusI, minusI.multiply(Complex.ONE));
        assertEquals(onePlusI, Complex.I.multiply(oneMinusI));
        assertEquals(oneMinusI, Complex.ONE.multiply(oneMinusI));
        assertEquals(twoI, onePlusI.multiply(onePlusI));
        assertEquals(two, onePlusI.multiply(oneMinusI));
    }

    @Test
    void testSquaredModulus(){
        assertEquals(1, Complex.ONE.squaredModulus());
        assertEquals(2, onePlusI.squaredModulus());
        assertEquals(244, new Complex(real, imaginary).squaredModulus());
    }

    @Test
    void testModulus(){
        assertEquals(1, Complex.ONE.modulus());
        assertEquals(Math.sqrt(2), onePlusI.modulus());
        assertEquals(Math.sqrt(244), new Complex(real, imaginary).modulus());
    }

    @Test
    void testPow(){
        assertEquals(Complex.ONE, Complex.ONE.pow(10));
        assertEquals(minusOne, Complex.I.pow(2));
        assertEquals(minusI, Complex.I.pow(3));
        assertEquals(Complex.ONE, Complex.I.pow(4));
        assertEquals(Complex.I, Complex.I.pow(5));
        assertEquals(new Complex(-2, 2), onePlusI.pow(3));
        assertEquals(new Complex(-2, -2), oneMinusI.pow(3));
        assertEquals(new Complex(16, 0), two.pow(4));
        assertEquals(new Complex(0, -128), twoI.pow(7));
    }
}