package br.com.analiseacoes.analiseacoes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddress;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.analiseacoes.analiseacoes.dto.RequestDividaLiquidaEbitDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestDividaLiquidaPatrimonioLiquidoDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestDyDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestEvEbitDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestGiroAtivosDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestLiquidezCorrenteDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestLiquidezMediaDiariaDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestLucrosCagr5DTO;
import br.com.analiseacoes.analiseacoes.dto.RequestMargemBrutaDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestMargemEbitDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestMargemLiquidaDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestPAtivoCirculanteDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestPAtivoDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestPCapitalGiroDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestPEbitDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestPSRDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestPassivoAtivoDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestPlAtivoDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestPlDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestPvpDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestReceitasCagr5DTO;
import br.com.analiseacoes.analiseacoes.dto.RequestRoaDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestRoeDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestRoicDTO;
import br.com.analiseacoes.analiseacoes.dto.RequestSearchDTO;
import br.com.analiseacoes.analiseacoes.model.DividendsDTO;
import br.com.analiseacoes.analiseacoes.model.ListOfTheStockBestSharesDTO;
import br.com.analiseacoes.analiseacoes.model.StockExchangeDTO;
import br.com.analiseacoes.analiseacoes.model.SummaryDyByYearDTO;

public class TesteChamada {

	public static void main(String[] args) {
//		sendPost();
		XLSXReaderWriter();
		System.out.println("Your excel file has been generated!");
	}

	private static void sendPost() {

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			int categoryType = 1;

			RequestSearchDTO rsDTO = new RequestSearchDTO();
			rsDTO.setSector("");
			rsDTO.setSubSector("");
			rsDTO.setSegment("");
			rsDTO.setMyRange("5;25");

			RequestDyDTO rdyDTO = new RequestDyDTO();
			rdyDTO.setItem1(5);
			rdyDTO.setItem2(null);
			rsDTO.setDy(rdyDTO);

			RequestPlDTO rplDTO = new RequestPlDTO();
			rplDTO.setItem1(null);
			rplDTO.setItem2(15);
			rsDTO.setpL(rplDTO);

			RequestPvpDTO rpvpDTP = new RequestPvpDTO();
			rpvpDTP.setItem1(null);
			rpvpDTP.setItem2(null);
			rsDTO.setpVp(rpvpDTP);

			RequestPAtivoDTO rpadto = new RequestPAtivoDTO();
			rpadto.setItem1(null);
			rpadto.setItem2(null);
			rsDTO.setpAtivo(rpadto);

			RequestMargemBrutaDTO rmbdto = new RequestMargemBrutaDTO();
			rmbdto.setItem1(null);
			rmbdto.setItem2(null);
			rsDTO.setMargemBruta(rmbdto);

			RequestMargemEbitDTO rmedto = new RequestMargemEbitDTO();
			rmedto.setItem1(null);
			rmedto.setItem2(null);
			rsDTO.setMargemEbit(rmedto);

			RequestMargemLiquidaDTO rmldto = new RequestMargemLiquidaDTO();
			rmldto.setItem1(null);
			rmldto.setItem2(null);
			rsDTO.setMargemLiquida(rmldto);

			RequestPEbitDTO rpedto = new RequestPEbitDTO();
			rpedto.setItem1(null);
			rpedto.setItem2(null);
			rsDTO.setpEbit(rpedto);

			RequestEvEbitDTO reedto = new RequestEvEbitDTO();
			reedto.setItem1(null);
			reedto.setItem2(null);
			rsDTO.seteVEbit(reedto);

			RequestDividaLiquidaEbitDTO rdledto = new RequestDividaLiquidaEbitDTO();
			rdledto.setItem1(null);
			rdledto.setItem2(null);
			rsDTO.setDividaLiquidaEbit(rdledto);

			RequestDividaLiquidaPatrimonioLiquidoDTO rdlpldto = new RequestDividaLiquidaPatrimonioLiquidoDTO();
			rdlpldto.setItem1(null);
			rdlpldto.setItem2(null);
			rsDTO.setDividaLiquidaPatrimonioLiquido(rdlpldto);

			RequestPSRDTO rpsrdto = new RequestPSRDTO();
			rpsrdto.setItem1(null);
			rpsrdto.setItem2(null);
			rsDTO.setPsr(rpsrdto);

			RequestPCapitalGiroDTO rpcgdto = new RequestPCapitalGiroDTO();
			rpcgdto.setItem1(null);
			rpcgdto.setItem2(null);
			rsDTO.setpCapitalGiro(rpcgdto);

			RequestPAtivoCirculanteDTO rpacdto = new RequestPAtivoCirculanteDTO();
			rpacdto.setItem1(null);
			rpacdto.setItem2(null);
			rsDTO.setpAtivoCirculante(rpacdto);

			RequestRoeDTO rroedto = new RequestRoeDTO();
			rroedto.setItem1(null);
			rroedto.setItem2(null);
			rsDTO.setRoe(rroedto);

			RequestRoicDTO rroicdto = new RequestRoicDTO();
			rroicdto.setItem1(null);
			rroicdto.setItem2(null);
			rsDTO.setRoic(rroicdto);

			RequestRoaDTO rroadto = new RequestRoaDTO();
			rroadto.setItem1(null);
			rroadto.setItem2(null);
			rsDTO.setRoa(rroadto);

			RequestLiquidezCorrenteDTO rlcdto = new RequestLiquidezCorrenteDTO();
			rlcdto.setItem1(null);
			rlcdto.setItem2(null);
			rsDTO.setLiquidezCorrente(rlcdto);

			RequestPlAtivoDTO rpladto = new RequestPlAtivoDTO();
			rpladto.setItem1(null);
			rpladto.setItem2(null);
			rsDTO.setPlAtivo(rpladto);

			RequestPassivoAtivoDTO rpasatidto = new RequestPassivoAtivoDTO();
			rpasatidto.setItem1(null);
			rpasatidto.setItem2(null);
			rsDTO.setPassivoAtivo(rpasatidto);

			RequestGiroAtivosDTO rgadto = new RequestGiroAtivosDTO();
			rgadto.setItem1(null);
			rgadto.setItem2(null);
			rsDTO.setGiroAtivos(rgadto);

			RequestReceitasCagr5DTO rrc5dto = new RequestReceitasCagr5DTO();
			rrc5dto.setItem1(null);
			rrc5dto.setItem2(null);
			rsDTO.setReceitasCagr5(rrc5dto);

			RequestLucrosCagr5DTO rlc5dto = new RequestLucrosCagr5DTO();
			rlc5dto.setItem1(null);
			rlc5dto.setItem2(null);
			rsDTO.setLucrosCagr5(rlc5dto);

			RequestLiquidezMediaDiariaDTO rlmddto = new RequestLiquidezMediaDiariaDTO();
			rlmddto.setItem1(500000);
			rlmddto.setItem2(null);
			rsDTO.setLiquidezMediaDiaria(rlmddto);

			try {
				// Converte objeto em json
				ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				String jsonRequestSearch = ow.writeValueAsString(rsDTO);

				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = null;
				try {
					jsonObject = (JSONObject) jsonParser.parse(jsonRequestSearch);
				} catch (ParseException e) {
					System.out.println(e);
				}

				String search = jsonObject.toString();
				String url = "https://statusinvest.com.br/category/advancedsearchresult?";

				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
				nameValuePairs.add(new BasicNameValuePair("search", search));
				nameValuePairs.add(new BasicNameValuePair("CategoryType", String.valueOf(categoryType)));

				URIBuilder uriBuilder = null;
				try {
					uriBuilder = new URIBuilder(url);
				} catch (URISyntaxException e) {
					System.out.println(e);
				}
				uriBuilder.addParameters(nameValuePairs);

				HttpGet get = new HttpGet(uriBuilder.toString());

				get.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

				CloseableHttpResponse response = httpClient.execute(get);

				int statusCode = response.getStatusLine().getStatusCode();

				if (statusCode == HttpStatus.SC_OK) {
					BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

					String line = "";
					while ((line = rd.readLine()) != null) {
						List<StockExchangeDTO> listStockExchangeDTO = seeksDividendsForEachShare(line);

						String path = "C:/Users/jailt/OneDrive/Área de Trabalho";
						String files = "/análise ações.xls";
						String subSector = "";
						try (OutputStream fileOut = new FileOutputStream(path + files)) {
							File file = new File(path + files);

							HSSFWorkbook workbook = new HSSFWorkbook();
							HSSFSheet sheet = null;
							HSSFRow row = null;

							for (StockExchangeDTO sedto : listStockExchangeDTO) {
								sheet = workbook.createSheet(sedto.getTicker());
								subSector = sendPostToApiToGetDividends(workbook, file, sheet, row, sedto);

								row = sheet.getRow(1);
								sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 3));
								row.createCell(1).setCellValue(subSector);
							}

							workbook.write(fileOut);
							fileOut.close();
							workbook.close();
						} catch (Exception e) {
							System.out.println(e);
						}

						// Aki lê
						XLSXReaderWriter();
					}
				}
			} catch (IOException e) {
				System.out.println("Erro " + e);
			}
		} catch (IOException e) {
			System.out.println("Erro " + e);
		}
	}

	private static List<StockExchangeDTO> seeksDividendsForEachShare(String acoes) {
		List<StockExchangeDTO> listStockExchangeDTO = createsStockExchangeList(acoes);

		// Ordena do maior para o menor pelo dy
		sortListBySpecificField(listStockExchangeDTO, null, null, "StockExchangeDTO");

		return listStockExchangeDTO;
	}

	private static void sortListBySpecificField(List<StockExchangeDTO> listStockExchangeDTO,
			List<DividendsDTO> listDividendsDTO, List<ListOfTheStockBestSharesDTO> lotsbsdto, String orderBy) {
		switch (orderBy) {
		case "StockExchangeDTO":
			Comparator<StockExchangeDTO> compareByDy = (StockExchangeDTO sedto1, StockExchangeDTO sedto2) -> Double
					.compare(sedto1.getDy(), sedto2.getDy());
			Collections.sort(listStockExchangeDTO, Collections.reverseOrder(compareByDy));

			break;
		case "DividendsDTO":
			Comparator<DividendsDTO> compareByPd = (DividendsDTO ddto1, DividendsDTO ddto2) -> {
				try {
					return new SimpleDateFormat("dd/MM/yyyy").parse(ddto1.getPd())
							.compareTo(new SimpleDateFormat("dd/MM/yyyy").parse(ddto2.getPd()));
				} catch (java.text.ParseException e) {
					System.out.println(e);
				}

				return 0;
			};

			Collections.sort(listDividendsDTO, Collections.reverseOrder(compareByPd));

			break;
		case "ListOfTheStockBestSharesDTO":
			Comparator<ListOfTheStockBestSharesDTO> compareByUltimos5Anos = (ListOfTheStockBestSharesDTO lotsbsdto1,
					ListOfTheStockBestSharesDTO lotsbsdto2) -> Double.compare(
							Double.valueOf(
									lotsbsdto1.getUltimo5Anos().replace("R$ ", "").replace("%", "").replace(",", ".")),
							Double.valueOf(
									lotsbsdto2.getUltimo5Anos().replace("R$ ", "").replace("%", "").replace(",", ".")));
			Collections.sort(lotsbsdto, Collections.reverseOrder(compareByUltimos5Anos));

			break;
		default:

		}
	}

	private static List<StockExchangeDTO> createsStockExchangeList(String acoes) {
		acoes = acoes.replace("[", "");
		acoes = acoes.replace("]", "");

		String[] arrOfStr = acoes.split("(?<=},)");

		List<StockExchangeDTO> listStockExchangeDTO = new ArrayList<StockExchangeDTO>();
		for (String sedto : arrOfStr) {
			sedto = sedto.replace("},", "}");

			ObjectMapper mapper = new ObjectMapper();
			StockExchangeDTO stockExchangeDTO = new StockExchangeDTO();
			try {
				stockExchangeDTO = mapper.readValue(sedto, StockExchangeDTO.class);
			} catch (IOException e) {
				System.out.println(e);
			}

			listStockExchangeDTO.add(stockExchangeDTO);
		}

		return listStockExchangeDTO;
	}

	private static String sendPostToApiToGetDividends(HSSFWorkbook workbook, File file, HSSFSheet sheet, HSSFRow row,
			StockExchangeDTO sedto) {

		String subSector = "";

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			try {
				String url = "https://statusinvest.com.br/acoes/" + sedto.getTicker();

				URIBuilder uriBuilder = null;
				try {
					uriBuilder = new URIBuilder(url);
				} catch (URISyntaxException e) {
					System.out.println(e);
				}

				HttpGet get = new HttpGet(uriBuilder.toString());

				get.addHeader(HTTP.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

				CloseableHttpResponse response = httpClient.execute(get);

				int statusCode = response.getStatusLine().getStatusCode();

				if (statusCode == HttpStatus.SC_OK) {
					String line = "";
					int controlador = 1;
					InputStream is = response.getEntity().getContent();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));

					// Localiza os dados da ação
					while ((line = br.readLine()) != null) {
						if ((line.toLowerCase().contains("input id=\"results\" name=\"results\""))
								&& String.valueOf(controlador).equals("1")) {
							controlador++;

							line = line.replace("<input id=\"results\" name=\"results\" type=\"hidden\" value=\"[", "");
							line = line.replace("]\" />", "");

							String[] arrOfStr = line.split("(?<=},)");

							List<DividendsDTO> listDividendsDTO = returnsTheDividendHistoryPerStockExchange(arrOfStr);

							sortListBySpecificField(null, listDividendsDTO, null, "DividendsDTO");

							CreateExlFile(workbook, file, sheet, row, sedto, listDividendsDTO, subSector);

							break;
						}
					}

					line = "";
					while ((line = br.readLine()) != null) {
						if ((line.contains("<a title=\"Ver outras empresas do subsetor "))) {
							String newLine = line.replace("<a title=\"Ver outras empresas do subsetor ", "");
							String[] arrOfStr = newLine.split("'");

							subSector = StringEscapeUtils.unescapeHtml4(arrOfStr[1]);
							break;
						}
					}

					br.close();
				}
			} catch (IOException e) {
				System.out.println("Erro " + e);
			}
		} catch (IOException e) {
			System.out.println("Erro " + e);
		}
		return subSector;
	}

	private static List<DividendsDTO> returnsTheDividendHistoryPerStockExchange(String[] arrOfStr) {
		List<DividendsDTO> listDividendsDTO = new ArrayList<DividendsDTO>();
		for (String divdto : arrOfStr) {
			divdto = divdto.replace("},", "}");

			divdto = divdto.replace("&quot;", "\"");

			ObjectMapper mapper = new ObjectMapper();
			DividendsDTO dividendsDTO = new DividendsDTO();
			try {
				dividendsDTO = mapper.readValue(divdto, DividendsDTO.class);
			} catch (IOException e) {
				System.out.println(e);
			}

			if (dividendsDTO.getPd().equals("-")) {
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR, 1900);
				cal.set(Calendar.MONTH, Calendar.JANUARY);
				cal.set(Calendar.DAY_OF_MONTH, 1);
				Date date = cal.getTime();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

				dividendsDTO.setPd(dateFormat.format(date));
			}

			DecimalFormat df = new DecimalFormat("#.######");
			String strDsv = dividendsDTO.getSv().replace(",", ".");
			Double dSv = Double.valueOf(strDsv);
			df.setRoundingMode(RoundingMode.HALF_UP);
			String rightPad = StringUtils.rightPad(String.valueOf(df.format(dSv)), 8, "0").replace(".", ",");
			String truncateString = rightPad.substring(0, Math.min(rightPad.length(), 8));

			dividendsDTO.setSv("R$ " + truncateString);

			listDividendsDTO.add(dividendsDTO);
		}

		return listDividendsDTO;
	}

	private static void CreateExlFile(HSSFWorkbook workbook, File file, HSSFSheet sheet, HSSFRow row,
			StockExchangeDTO sedto, List<DividendsDTO> listDividendsDTO, String subSector) {
		if (file.exists() && !file.isDirectory())
			file.delete();

		// Gera histórico dos dividendos
		generateDividendHistory(row, sedto, listDividendsDTO, sheet, subSector);
	}

	private static void generateDividendHistory(HSSFRow row, StockExchangeDTO sedto,
			List<DividendsDTO> listDividendsDTO, HSSFSheet sheet, String subSector) {
		try {
			// Cria primeira linha do xls
			int rowNum = 0;
			row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue("PREÇO");
			row.createCell(1).setCellValue("SETOR");
			rowNum++;

			// Cria segunda linha
			row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue("R$ " + String.valueOf(sedto.getPrice()).replace(".", ","));
			row.createCell(1).setCellValue("SETOR");
			rowNum++;

			// Cria as linhas do histórico dos dividendos
			row = sheet.createRow(rowNum);
			List<SummaryDyByYearDTO> summary = new ArrayList<SummaryDyByYearDTO>();
			List<SummaryDyByYearDTO> listDividendSummary = null;
			for (DividendsDTO dividendsDTO : listDividendsDTO) {
				row.createCell(0).setCellValue(dividendsDTO.getEt());
				row.createCell(1).setCellValue(dividendsDTO.getEd());
				row.createCell(2).setCellValue(dividendsDTO.getPd());
				row.createCell(3).setCellValue(dividendsDTO.getSv());

				listDividendSummary = generateDividendSummary(summary, dividendsDTO, row);

				rowNum++;
				row = sheet.createRow(rowNum);
			}

			// Cria sumários
			int colNum = 5;
			row = sheet.getRow(5);

			int tamanhoList = listDividendSummary.size();
			if (tamanhoList <= 1) {
				row = sheet.createRow(5);
				row.createCell(5).setCellValue("% RENDIMENTO ANO");
				rowNum++;

				// Cria mescla da média dos últimos 5 anos
				row = sheet.createRow(8);
				sheet.addMergedRegion(new CellRangeAddress(8, 8, 5, 9));
				row.createCell(5).setCellValue("% MÉDIA ÚLTIMOS 5 ANOS");
				row = sheet.createRow(9);
				sheet.addMergedRegion(new CellRangeAddress(9, 9, 5, 9));

				// Cria mescla da média dos últimos 10 anos
				row = sheet.getRow(8);
				sheet.addMergedRegion(new CellRangeAddress(8, 8, 10, 14));
				row.createCell(10).setCellValue("% MÉDIA ÚLTIMOS 10 ANOS");
				row = sheet.getRow(9);
				sheet.addMergedRegion(new CellRangeAddress(9, 9, 10, 14));
			} else {
				sheet.addMergedRegion(new CellRangeAddress(5, 5, 5, (tamanhoList + colNum) - 1));
				row.createCell(5).setCellValue("% RENDIMENTO ANO");

				// Cria mescla da média dos últimos 5 anos
				row = sheet.getRow(8);
				sheet.addMergedRegion(new CellRangeAddress(8, 8, 5, 9));
				row.createCell(5).setCellValue("% MÉDIA ÚLTIMOS 5 ANOS");
				row = sheet.getRow(9);
				sheet.addMergedRegion(new CellRangeAddress(9, 9, 5, 9));

				// Cria mescla da média dos últimos 10 anos
				row = sheet.getRow(8);
				sheet.addMergedRegion(new CellRangeAddress(8, 8, 10, 14));
				row.createCell(10).setCellValue("% MÉDIA ÚLTIMOS 10 ANOS");
				row = sheet.getRow(9);
				sheet.addMergedRegion(new CellRangeAddress(9, 9, 10, 14));
			}

			double averageOverThePastFewyears = 0;
			for (int i = 0; i < listDividendSummary.size(); i++) {
				row = sheet.getRow(2);
				row.createCell(colNum).setCellValue(listDividendSummary.get(i).getAno());
				row = sheet.getRow(3);

				DecimalFormat df1 = new DecimalFormat("###.######");
				Double dSv = listDividendSummary.get(i).getValor();
				df1.setRoundingMode(RoundingMode.HALF_UP);
				String rightPad = StringUtils.rightPad(String.valueOf(df1.format(dSv)), 8, "0");
				String truncateString = rightPad.substring(0, Math.min(rightPad.length(), 8));

				String valor = truncateString.replace(".", ",");
				row.createCell(colNum).setCellValue("R$ " + valor.substring(0, 4));

				DecimalFormat df = new DecimalFormat("###.##");
				df.setRoundingMode(RoundingMode.HALF_UP);

				if (listDividendSummary.size() <= 1) {
					row = sheet.createRow(6);
				} else {
					row = sheet.getRow(6);
				}

				double percentagePerLot = ((listDividendSummary.get(i).getValor() * 100) * 100);
				double lotPrice = 100 * sedto.getPrice();
				double doublePercent = percentagePerLot / lotPrice;
				String strPocentagem = df.format(doublePercent);
				row.createCell(colNum).setCellValue(String.valueOf(strPocentagem).replace(".", ",") + " %");
				colNum++;

				// Sumário dos últimos anos
				if (i >= 0 && i < 10) {
					averageOverThePastFewyears = averageOverThePastFewyears + doublePercent;

					if (listDividendSummary.size() <= 1) {
						row = sheet.createRow(9);
					} else {
						row = sheet.getRow(9);
					}

					// Sumário dos últimos 5 anos
					if (i < 5) {
						row.createCell(5).setCellValue(
								String.valueOf(averageOverThePastFewyears / 5).substring(0, 4).replace(".", ",")
										+ " %");
					}

					// Sumário dos últimos 10 anos
					row.createCell(10).setCellValue(
							String.valueOf(averageOverThePastFewyears / 10).substring(0, 4).replace(".", ",") + " %");
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static List<SummaryDyByYearDTO> generateDividendSummary(List<SummaryDyByYearDTO> newSummary,
			DividendsDTO dividendsDTO, HSSFRow row) {
		int indice = 0;
		boolean atualiza = false; // insere ou atualiza pelo índice
		for (int i = 0; i < newSummary.size(); i++) {
			if (newSummary.get(i).getAno().equals(dividendsDTO.getPd().substring(6, 10))) {
				atualiza = true;
				indice = i;
			}
		}

		if (!atualiza) {
			newSummary = addNewList(newSummary, dividendsDTO);
		}

		if (atualiza) {
			Double listValor = newSummary.get(indice).getValor();
			String strSv = dividendsDTO.getSv().replace("R$ ", "").replace(",", ".");

			DecimalFormat df = new DecimalFormat("###.######");
			Double dSv = Double.valueOf(strSv);
			df.setRoundingMode(RoundingMode.HALF_UP);
			String rightPad = StringUtils.rightPad(String.valueOf(df.format(dSv)), 8, "0");
			String truncateString = rightPad.substring(0, Math.min(rightPad.length(), 8));

			newSummary.get(indice).setValor(listValor + Double.valueOf(truncateString.replace(",", ".")));
		}

		return newSummary;
	}

	private static List<SummaryDyByYearDTO> addNewList(List<SummaryDyByYearDTO> summary, DividendsDTO dividendsDTO) {
		String strSv = dividendsDTO.getSv().replace("R$ ", "").replace(",", ".");

		DecimalFormat df = new DecimalFormat("###.######");
		Double dSv = Double.valueOf(strSv);
		df.setRoundingMode(RoundingMode.HALF_UP);
		String rightPad = StringUtils.rightPad(String.valueOf(df.format(dSv)), 8, "0");
		String truncateString = rightPad.substring(0, Math.min(rightPad.length(), 8));

		SummaryDyByYearDTO sdbyDTO = new SummaryDyByYearDTO();
		sdbyDTO.setAno(dividendsDTO.getPd().substring(6, 10));
		sdbyDTO.setValor(Double.valueOf(truncateString.replace(",", ".")));

		summary.add(sdbyDTO);
		return summary;
	}

	private static void XLSXReaderWriter() {
		try {
			String path = "C:/Users/jailt/OneDrive/Área de Trabalho";
			String files = "/análise ações.xls";

			File excel = new File(path + files);
			FileInputStream fis = new FileInputStream(excel);
			POIFSFileSystem fs = new POIFSFileSystem(fis);
			HSSFWorkbook book = new HSSFWorkbook(fs);

			HSSFSheet sheet = null;
			List<ListOfTheStockBestSharesDTO> listLotsbs = new ArrayList<ListOfTheStockBestSharesDTO>();
			for (int i = 0; i < book.getNumberOfSheets(); i++) {
				sheet = book.getSheetAt(i);

				ListOfTheStockBestSharesDTO lotsbs = new ListOfTheStockBestSharesDTO();
				lotsbs.setAcao(sheet.getSheetName());
				lotsbs.setPreco(sheet.getRow(1).getCell(0).toString());
				lotsbs.setSetor(sheet.getRow(1).getCell(1).toString());
				lotsbs.setUltimo5Anos(sheet.getRow(9).getCell(5).toString());
				lotsbs.setUltimo10Anos(sheet.getRow(9).getCell(10).toString());

				listLotsbs.add(lotsbs);
			}

			book.close();
			fs.close();
			fis.close();

			try (OutputStream fileOut = new FileOutputStream(path + "/Top acoes.xls")) {
				HSSFWorkbook workbook = new HSSFWorkbook();
				HSSFRow row = null;
				sheet = workbook.createSheet("acoes");

				File file = new File(path + "/Top acoes.xls");
				if (file.exists() && !file.isDirectory())
					file.delete();

				int line = 0;
				row = sheet.createRow(line);
				row.createCell(0).setCellValue("AÇÕES");
				row.createCell(1).setCellValue("PREÇO");
				row.createCell(2).setCellValue("SETOR");
				row.createCell(3).setCellValue("Últ. 5 anos");
				row.createCell(4).setCellValue("Últ. 10 anos");
				line++;

				sortListBySpecificField(null, null, listLotsbs, "ListOfTheStockBestSharesDTO");

				for (ListOfTheStockBestSharesDTO lotsbs : listLotsbs) {
					row = sheet.createRow(line);
					row.createCell(0).setCellValue(lotsbs.getAcao());
					row.createCell(1).setCellValue(lotsbs.getPreco());
					row.createCell(2).setCellValue(lotsbs.getSetor());
					row.createCell(3).setCellValue(lotsbs.getUltimo5Anos());
					row.createCell(4).setCellValue(lotsbs.getUltimo10Anos());
					line++;
				}

				workbook.write(fileOut);
				workbook.close();
				fileOut.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
