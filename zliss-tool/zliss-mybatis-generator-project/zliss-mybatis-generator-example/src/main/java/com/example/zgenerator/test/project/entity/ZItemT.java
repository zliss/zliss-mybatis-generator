package com.example.zgenerator.test.project.entity;

public class ZItemT {

    private Long id; // Type:BIGINT UNSIGNED, Default:null, Remark:id
    private String type; // Type:VARCHAR, Default:"", Remark:type
    private String url; // Type:VARCHAR, Default:"", Remark:url
    private Byte status; // Type:TINYINT, Default:0, Remark:status

    public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

    public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return this.type;
	}

    public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return this.url;
	}

    public void setStatus(Byte status){
		this.status = status;
	}

	public Byte getStatus(){
		return this.status;
	}

}