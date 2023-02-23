package com.example.demo.employers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;



@Service
public class EmployersService{


	private EmployersRepository employersRepository;


	public EmployersService(EmployersRepository employersRepository) {
		this.employersRepository = employersRepository;
	}

	public List<Employers> getEmployers()
	{
		return employersRepository.findAll();
	}

    public void addNewEmployers(Employers employers) {
		Optional<Employers> employersOptional = employersRepository
		.findEmployersbyEmail(employers.getEmail());
		if (employersOptional.isPresent())
		{
			throw new IllegalStateException("email has existed in DB!");
		}
		employersRepository.save(employers);
    }

	public void deleteEmployer(Integer employerId) {
		Boolean exists = employersRepository.existsById(employerId);
		if(!exists)
		{
			throw new IllegalStateException("Employer with id "+ employerId + "doe not exist!");
		}
		employersRepository.deleteById(employerId);
	}
}

