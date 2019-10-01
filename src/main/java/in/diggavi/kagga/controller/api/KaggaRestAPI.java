package in.diggavi.kagga.controller.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.diggavi.kagga.entity.Kagga;
import in.diggavi.kagga.model.KaggaModel;
import in.diggavi.kagga.service.KaggaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/kagga/")
public class KaggaRestAPI {

	@Autowired
	private KaggaService kaggaService;

	@GetMapping("/")
	@ApiOperation(value = "Gets list of all kagga")
	public List<KaggaModel> allKagga(@RequestParam(name = "q", defaultValue = "") String searchKey) {
		List<KaggaModel> list = kaggaService.getAllKagga().stream()
				.map(k -> new KaggaModel(k.getKagga_id(), k.getKagga_kn(), k.getKagga_eng(), k.getKagga_latn()))
				.collect(Collectors.toList());
		if (!searchKey.equals("")) {
			list = list.stream().filter(km -> km.getKagga_trans().toLowerCase().contains(searchKey.toLowerCase()))
					.collect(Collectors.toList());
		}
		return list;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Finds perticular kagga by its id")
	public KaggaModel singleKagga(@PathVariable("id") long id) {
		Kagga k = kaggaService.getKaggaById(id);
		return new KaggaModel(k.getKagga_id(), k.getKagga_kn(), k.getKagga_eng(), k.getKagga_latn());
	}

}
