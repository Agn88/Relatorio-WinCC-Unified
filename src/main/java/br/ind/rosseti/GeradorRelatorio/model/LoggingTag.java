package br.ind.rosseti.GeradorRelatorio.model;

public class LoggingTag {

	private long pk_Key;
	private long tagObjectId;
	private long tagElementId;
	private long loggingTagId;
	private long fk_LogId;
	private String nome;
	private String pk_StartTime;

	public LoggingTag() {
		super();
	}

	public LoggingTag(long pk_Key, long tagObjectId, long tagElementId, long loggingTagId, long fk_LogId, String nome,
			String pk_StartTime) {
		super();
		this.pk_Key = pk_Key;
		this.tagObjectId = tagObjectId;
		this.tagElementId = tagElementId;
		this.loggingTagId = loggingTagId;
		this.fk_LogId = fk_LogId;
		this.nome = nome;
		this.pk_StartTime = pk_StartTime;
	}

	public long getPk_Key() {
		return pk_Key;
	}

	public void setPk_Key(long pk_Key) {
		this.pk_Key = pk_Key;
	}

	public long getTagObjectId() {
		return tagObjectId;
	}

	public void setTagObjectId(long tagObjectId) {
		this.tagObjectId = tagObjectId;
	}

	public long getTagElementId() {
		return tagElementId;
	}

	public void setTagElementId(long tagElementId) {
		this.tagElementId = tagElementId;
	}

	public long getLoggingTagId() {
		return loggingTagId;
	}

	public void setLoggingTagId(long loggingTagId) {
		this.loggingTagId = loggingTagId;
	}

	public long getFk_LogId() {
		return fk_LogId;
	}

	public void setFk_LogId(long fk_LogId) {
		this.fk_LogId = fk_LogId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		String formatar = nome;
		formatar = formatar.replace("HMI_RT_1::", "").replace("DB_AI_AI_", "AI_").replace("DB_AO_AO_", "AO_").replace("DB_", "").replace("CPU520_1_776_", "CPU520.1-776 - ").replace("CPU120_1_671_", "CPU120.1-671 - ");
		
		String[] array = formatar.split(":");
		
		
		
		this.nome = array[0];
	}

	public String getPk_StartTime() {
		return pk_StartTime;
	}

	public void setPk_StartTime(String pk_StartTime) {
		this.pk_StartTime = pk_StartTime;
	}

	
	
}
