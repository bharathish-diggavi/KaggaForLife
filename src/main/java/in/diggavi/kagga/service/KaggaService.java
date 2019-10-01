package in.diggavi.kagga.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import in.diggavi.kagga.entity.Kagga;
import in.diggavi.kagga.repository.KaggaRepository;

@Service
public class KaggaService {

	private KaggaRepository kaggaRepository;

	@Autowired
	public KaggaService(KaggaRepository kaggaRepository)
			throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		this.kaggaRepository = kaggaRepository;
		Gson gson = new Gson();
		Type type = new TypeToken<List<Kagga>>() {
		}.getType();
		JsonArray jarray = gson.fromJson(
				new FileReader(System.getProperty("user.dir") + "/src/main/resources/masterfiles/mankutimma.json"),
				JsonArray.class);

		List<Kagga> list = gson.fromJson(jarray, type);
		list.forEach(kaggaRepository::save);
	}

	public List<Kagga> getAllKagga() {
		return kaggaRepository.findAll();
	}

	public Kagga getKaggaById(long id) {
		return kaggaRepository.getOne(id);
	}

}
