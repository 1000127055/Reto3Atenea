package Reto3Atenea.USA.com.Service;

import Reto3Atenea.USA.com.Model.Admin;
import Reto3Atenea.USA.com.Model.Car;
import Reto3Atenea.USA.com.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save (Admin admin){
        if(admin.getIdAdmin()== null){
            return adminRepository.save(admin);
        }else{
                Optional<Admin> adminEncontrado =getAdmin(admin.getIdAdmin());
                if(adminEncontrado.isEmpty()){
                    return adminRepository.save(admin);
                }else{
                        return admin;
                }
        }
    }

    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin> adminEncontrado = getAdmin(admin.getIdAdmin());
            if(adminEncontrado.isPresent()){
                if(admin.getAge()!=null){
                    adminEncontrado.get().setAge(admin.getAge());
                }
                if(admin.getName()!=null){
                    adminEncontrado.get().setName(admin.getName());
                }
                if (admin.getEmail() != null){
                    adminEncontrado.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword()!=null){
                    adminEncontrado.get().setPassword(admin.getPassword());
                }
                return adminRepository.save(adminEncontrado.get());
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }
    public boolean deleteAdmin(int id){
        Boolean respuesta = getAdmin(id).map(admin ->{
            adminRepository.delete(admin);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
