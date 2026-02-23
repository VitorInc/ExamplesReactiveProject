import com.example.reactiveProjectExample.modulo01.entity.CustomerOrder
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

// ✅ MELHOR
@Table("customer")
data class Customer(
    @Id
    @Column("id")val id: Int? = null,
    @Column("name") val name: String,
    @Column("email") val email: String
) {

}