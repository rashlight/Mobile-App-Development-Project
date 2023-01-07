package a1.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import a1.model.ItemDTO;
import a1.repository.ItemRepository;
import a1.repository.entity.ItemEntity;

import java.util.ArrayList;

import java.util.List;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepo;
	
	public List<ItemDTO> findAll(){
		List<ItemDTO> results = new ArrayList<>();
		List<ItemEntity> itemEntities = itemRepo.findAll();
		for (ItemEntity i : itemEntities) {
			ItemDTO item = new ItemDTO();
			item.setId(i.getId());
			item.setName(i.getName());
			results.add(item);
		}
		return results;
	}
	
	public void addItem(ItemDTO item) {
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setName(item.getName());
		itemRepo.save(itemEntity);
	}
	
	public void deleteById(Long itemNo) {
		itemRepo.deleteById(itemNo);
	}
	
	public void updateItem(ItemDTO item) {
		ItemEntity itemEntity = itemRepo.findById(item.getId()).get();
		itemEntity.setName(item.getName());
		itemRepo.save(itemEntity);
	}

}
