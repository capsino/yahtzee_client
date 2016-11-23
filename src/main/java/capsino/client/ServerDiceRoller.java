package capsino.client;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class ServerDiceRoller implements DiceRoller {

	private final String YAHTZEE_SERVER_URL = "http://yahtzee_server:4567/";

	private YahtzeeResponse response = null;

	@Override
	public DiceRoll rollDice() {

		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpGet get = new HttpGet(YAHTZEE_SERVER_URL);

			YahtzeeResponse response = execute(client, get);
			if (response.getStatusCode() == 200) {
				Gson gson = new Gson();
				DiceRoll diceRoll = gson.fromJson(response.body, DiceRoll.class);

				return diceRoll;
			}
			else {
				throw new YahtzeeClientException("Unable to call Yahtzee server: status code=" +  response.getStatusCode());
			}
		}
		catch (IOException e) {
			throw new YahtzeeClientException("Unable to call Yahtzee server", e);
		}

	}

	YahtzeeResponse execute(CloseableHttpClient client, HttpGet request) {

		if (this.response != null)
			return this.response;

		try (CloseableHttpResponse response = client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			String body = null;

			if (statusCode == 200) {
				body = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
			return new YahtzeeResponse(statusCode, body);
		}
		catch (IOException e) {
			throw new YahtzeeClientException("Unable to call Yahtzee server", e);
		}

	}

	void setResponse(YahtzeeResponse response) {
		this.response = response;
	}

	static class YahtzeeResponse {

		private final int statusCode;
		private final String body;

		public YahtzeeResponse(int statusCode, String body) {
			super();
			this.statusCode = statusCode;
			this.body = body;
		}

		public String getBody() {
			return body;
		}

		public int getStatusCode() {
			return statusCode;
		}

	}

}
