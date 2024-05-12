package com.example.zgenerator.test.project.entity;

public class ZUser {

    private Long id; // Type:BIGINT UNSIGNED, Default:null, Remark:id
    private String phone; // Type:VARCHAR, Default:"", Remark:phone
    private String name; // Type:VARCHAR, Default:"", Remark:name
    private String img; // Type:VARCHAR, Default:"", Remark:img
    private Byte status; // Type:TINYINT, Default:0, Remark:status

    public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

    public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return this.phone;
	}

    public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

    public void setImg(String img){
		this.img = img;
	}

	public String getImg(){
		return this.img;
	}

    public void setStatus(Byte status){
		this.status = status;
	}

	public Byte getStatus(){
		return this.status;
	}

}