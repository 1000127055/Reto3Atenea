package Reto3Atenea.USA.com.Repository;

import Reto3Atenea.USA.com.Model.Admin;
import Reto3Atenea.USA.com.Repository.CRUD.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> findAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }

    public Admin save (Admin admin){
        return adminCrudRepository.save(admin);
    }

    public void delete (Admin admin){
        adminCrudRepository.delete(admin);
    }
}
