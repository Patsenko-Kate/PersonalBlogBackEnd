package kate.patsenko.blog.dao;
import kate.patsenko.blog.model.Person;
import java.sql.Types;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonJdbcDAO implements DAO<Person> {

    private JdbcTemplate jdbcTemplate;

    public PersonJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Person> rowMapper = (rs, rowNum) -> {
        Person person = new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setSurname(rs.getString("surname"));
        person.setEmail(rs.getString("email"));
        return person;
    };

    @Override
    public List<Person> list() {
        String sql = "SELECT id, name, surname, email FROM Person";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(Person person) {
        String sql = "INSERT INTO Person(name, surname, email) VAlUES(?,?,?)";
        jdbcTemplate.update(sql, person.getName(), person.getSurname(), person.getEmail());
    }

    @Override
    public Optional<Person> get(int id) {
        String sql = "SELECT * FROM PERSON WHERE id = ?;";
        Person person = null;
        jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.INTEGER}, rowMapper);
        return Optional.ofNullable(person);
    }

    @Override
    public void update(Person person, int id) {
        String sql = "UPDATE Person SET name = ?, surname = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, person.getName(), person.getSurname(), person.getEmail(), id);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }
}
