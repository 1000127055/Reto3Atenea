package Reto3Atenea.USA.com.Repository;

import Reto3Atenea.USA.com.Model.Client;
import Reto3Atenea.USA.com.Repository.CRUD.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> findAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save (Client client){
        return clientCrudRepository.save(client);
    }

    public void delete (Client client){
        clientCrudRepository.delete(client);
    }
}
