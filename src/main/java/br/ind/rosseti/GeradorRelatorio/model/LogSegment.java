package br.ind.rosseti.GeradorRelatorio.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LogSegment {

	private String name;

	// DataHora em timezone GMT
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant UTC_TimeStamp;

	private long qualityCode;

	private float value;

	public LogSegment() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getUTC_TimeStamp() {
		return UTC_TimeStamp;
	}

	public void setUTC_TimeStamp(Instant uTC_TimeStamp) {
		UTC_TimeStamp = uTC_TimeStamp;
	}

	public long getQualityCode() {
		return qualityCode;
	}

	public void setQualityCode(long qualityCode) {
		this.qualityCode = qualityCode;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "LogSegment [name=" + name + ", UTC_TimeStamp=" + getDatahoraConsultaYYYYMMDD() + ", qualityCode=" + qualityCode
				+ ", value=" + value + "]";
	}

	public String getDatahoraConsultaYYYYMMDD() {

		DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
				.withZone(ZoneId.systemDefault());

		String out = DATE_TIME_FORMATTER.format(UTC_TimeStamp);

		return out;
	}

}
