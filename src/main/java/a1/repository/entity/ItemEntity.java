package a1.repository.entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="item")
public class ItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	 @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	 private List<CartItemEntity> cartItem = new ArrayList<>();
	 
	 private Integer price;

	public ItemEntity(Long id) {
		super();
		this.id = id;
	}

	public ItemEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	

}
