package edu.orangecoastcollege.cs272.ic15.controller;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import edu.orangecoastcollege.cs272.ic15.model.WeatherObservation;
import edu.orangecoastcollege.cs272.ic15.model.WeatherStation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WeatherController {

	public WeatherObservation getCurrentWeather(String xmlURL) {
		WeatherObservation currentWeather = null;

		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dbfactory.newDocumentBuilder();
			Document doc = builder.parse(xmlURL);

			XPathFactory xpfactory = XPathFactory.newInstance();
			XPath path = xpfactory.newXPath();

			String stationId = path.evaluate("current_observation/station_id", doc);
			String location = path.evaluate("current_observation/location", doc);
			String weather = path.evaluate("current_observation/weather", doc);
			double temp = Double.parseDouble(path.evaluate("current_observation/temp_f", doc));
			double dewpoint = Double.parseDouble(path.evaluate("current_observation/dewpoint_f", doc));
			double visibility = Double.parseDouble(path.evaluate("current_observation/visibility_mi", doc));
			String wind = path.evaluate("current_observation/wind_string", doc);
			currentWeather = new WeatherObservation(stationId, location, weather, temp, dewpoint, visibility, wind);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentWeather;

	}

	public ObservableList<WeatherStation> getCAWeatherStations() {
		ObservableList<WeatherStation> allWeatherStations = FXCollections.observableArrayList();
		try {
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbfactory.newDocumentBuilder();
			Document doc = builder.parse(new File("weather_stations.xml"));

			XPathFactory xpfactory = XPathFactory.newInstance();
			XPath path = xpfactory.newXPath();

			// Get the count of all weather stations
			int count = Integer.parseInt(path.evaluate("count(wx_station_index/station)", doc));
			for (int i = 1; i <= count; i++) {
				String state = path.evaluate("wx_station_index/station[" + i + "]/state", doc);
				if (state.toUpperCase().contains("CA")) {

					String stationId = path.evaluate("wx_station_index/station[" + i + "]/station_id", doc);
					String stationName = path.evaluate("wx_station_index/station[" + i + "]/station_name", doc);

					String xMLURL = path.evaluate("wx_station_index/station[" + i + "]/xml_url", doc);
					allWeatherStations.add(new WeatherStation(stationId, stationName, state, xMLURL));
				}
			}
		} catch (Exception e) {
		}
		return allWeatherStations;
	}

}
