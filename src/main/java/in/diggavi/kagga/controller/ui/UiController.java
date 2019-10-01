package in.diggavi.kagga.controller.ui;

import java.io.FileNotFoundException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import in.diggavi.kagga.service.KaggaService;

@Controller
public class UiController {

	@Autowired
	private KaggaService kaggaService;

	@GetMapping("/")
	public String index(ModelMap map) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		map.put("kaggas", kaggaService.getAllKagga().subList(0, 3));
		return "index";
	}

	@GetMapping("/kagga/{id}")
	public String singleKagga(@PathVariable("id") long id, ModelMap map)
			throws JsonSyntaxException, JsonIOException, FileNotFoundException {

		map.put("kagga", kaggaService.getKaggaById(id));
		return "kagga";

	}

	@GetMapping("/all-kagga")
	public String allKagga(ModelMap map) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		map.put("kaggas", kaggaService.getAllKagga());
		return "all-kagga";

	}

	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "404";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "500";
			}
		}
		return "500";
	}
}
