package br.com.projects.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.projects.exception.UnsuportedOperationException;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Unsuported operation. Set a number value.");
		}
		Double sum = convertDouble(numberOne) + convertDouble(numberTwo);
		return sum;
	}

	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Unsuported operation. Set a number value.");
		}
		Double sub = convertDouble(numberOne) - convertDouble(numberTwo);
		return sub;
	}

	@RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Unsuported operation. Set a number value.");
		}
		Double mul = convertDouble(numberOne) * convertDouble(numberTwo);
		return mul;
	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Unsuported operation. Set a number value.");
		}
		Double div = convertDouble(numberOne) / convertDouble(numberTwo);
		return div;
	}

	@RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Unsuported operation. Set a number value.");
		}
		Double med = (convertDouble(numberOne) / convertDouble(numberTwo)) / 2;
		return med;
	}

	@RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
	public Double sqrt(@PathVariable("number") String number) throws Exception {

		if (!isNumeric(number)) {
			throw new UnsuportedOperationException("Unsuported operation. Set a number value.");
		}
		Double sqrt = Math.sqrt(convertDouble(number));
		return sqrt;
	}

	private Double convertDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		if (isNumeric(strNumber))
			return Double.parseDouble(strNumber);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		return strNumber.replaceAll(",", ".").matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
