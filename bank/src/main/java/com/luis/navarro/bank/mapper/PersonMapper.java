package com.luis.navarro.bank.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.luis.navarro.bank.dto.PersonDTO;
import com.luis.navarro.bank.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PersonMapper {

	/**
	 * @param person
	 * @return
	 */
	public PersonDTO toModel(Person person) {
		return PersonDTO.builder()
				.names(person.getNames())
				.surnames(person.getSurnames())
				.gender(person.getGender())
				.age(person.getAge())
				.documentId(person.getDocumentId())
				.address(person.getAddress())
				.telephone(person.getTelephone())
				.build();
	}
	
	/**
	 * @param personDTO
	 * @return
	 */
	public Person toEntity(PersonDTO personDTO) {
		return Person.builder()
				.names(personDTO.getNames())
				.surnames(personDTO.getSurnames())
				.gender(personDTO.getGender())
				.age(personDTO.getAge())
				.documentId(personDTO.getDocumentId())
				.address(personDTO.getAddress() != null && StringUtils.hasText(personDTO.getAddress()) ? personDTO.getAddress() : "")
				.telephone(personDTO.getTelephone() != null && StringUtils.hasText(personDTO.getTelephone()) ? personDTO.getTelephone() : "")
				.build();
	}
	
	/**
	 * @param person
	 * @return
	 */
	public List<PersonDTO> toModelList(List<Person> person) {
		List<PersonDTO> newListPerson = new ArrayList<>();
		log.info("LGTML001: Counter Record {}", person.size());
		person.stream().forEach(info -> {
			PersonDTO newPerson = new PersonDTO();
			newPerson.setNames(info.getNames());
			newPerson.setSurnames(info.getSurnames());
			newPerson.setGender(info.getGender());
			newPerson.setAge(info.getAge());
			newPerson.setDocumentId(info.getDocumentId());
			newPerson.setAddress(info.getAddress() != null && StringUtils.hasText(info.getAddress()) ? info.getAddress() : "---");
			newPerson.setTelephone(info.getTelephone() != null && StringUtils.hasText(info.getTelephone()) ? info.getTelephone() : "---");
			newListPerson.add(newPerson);
		});
		return newListPerson;
	}
}
