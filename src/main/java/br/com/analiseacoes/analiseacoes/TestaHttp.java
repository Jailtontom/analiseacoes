package br.com.analiseacoes.analiseacoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestaHttp {

	public static void main(String[] args) {
		sendPost();
	}

	private static void sendPost() {

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {

			HttpPost post = new HttpPost("https://api.userede.com.br/desenvolvedores/v1/transactions");

			post.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			post.addHeader("Authorization", "BASIC MTAwMDEwNzE6YzM1OGVhYTNmMzg0NDEzYjlkN2YzODVkNWY4NTRkYTM=");

			try {
				Random random = new Random();
				
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
				nameValuePairs.add(new BasicNameValuePair("capture", "false"));
				nameValuePairs.add(new BasicNameValuePair("reference", UUID.randomUUID().toString()));
				nameValuePairs.add(new BasicNameValuePair("amount", "5000"));
				nameValuePairs.add(new BasicNameValuePair("cardholderName", "App Postman"));
				nameValuePairs.add(new BasicNameValuePair("cardNumber", "5448280000000007"));
				nameValuePairs.add(new BasicNameValuePair("expirationMonth", "12"));
				nameValuePairs.add(new BasicNameValuePair("expirationYear", "2020"));
				nameValuePairs.add(new BasicNameValuePair("securityCode", "235"));

				RequestDTO requestDTO = new RequestDTO();
				requestDTO.setCapture(false);
//				requestDTO.setReference(UUID.randomUUID().toString());
				requestDTO.setReference(String.valueOf(random.nextInt()));
				requestDTO.setAmount(50);
				requestDTO.setCardholderName("App Postman");
				requestDTO.setCardNumber("5448280000000007");
				requestDTO.setExpirationMonth(12);
				requestDTO.setExpirationYear(2020);
				requestDTO.setSecurityCode("235");
//				post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(requestDTO);
				System.out.println(jsonString);

				StringEntity params = new StringEntity(jsonString);
				post.setEntity(params);

				HttpResponse response = httpClient.execute(post);

				int statusCode = response.getStatusLine().getStatusCode();

				if (statusCode == HttpStatus.SC_OK) {
					BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

					String line = "";
					while ((line = rd.readLine()) != null) {
						System.out.println(line);
						if (line.startsWith("Auth=")) {
							String key = line.substring(5);
							// do something with the key
						}

					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {

			System.out.println("Erro " + e);

		}

//		HttpClient client = new DefaultHttpClient();
	}

}