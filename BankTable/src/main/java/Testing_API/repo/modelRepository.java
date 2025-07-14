package Testing_API.repo;

import Testing_API.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@org.springframework.stereotype.Repository
@Repository
public interface modelRepository extends JpaRepository <Model,Long>{


}
