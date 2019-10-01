package in.diggavi.kagga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KaggaForLifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaggaForLifeApplication.class, args);
	}

	/*
	 * @Bean public List<Kagga> allKagga() throws JsonSyntaxException,
	 * JsonIOException, FileNotFoundException { Gson gson = new Gson(); Type type =
	 * new TypeToken<List<Kagga>>() { }.getType(); JsonArray jarray = gson.fromJson(
	 * new FileReader(System.getProperty("user.dir") +
	 * "/src/main/resources/masterfiles/mankutimma.json"), JsonArray.class);
	 * 
	 * List<Kagga> list = gson.fromJson(jarray, type); return list; }
	 */

}
