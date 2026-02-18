import com.example.reactiveProjectExample.modulo01.entity.CustomerOrder
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

// ✅ MELHOR
@Table("customer")
class Customer(
    @Id
    @Column("id")val id: Int? = null,
    val name: String,
    val email: String
) {
    @Transient
    var orders: List<CustomerOrder> = emptyList()  // Não afeta equals/hashCode

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Customer) return false
        return id == other.id  // Apenas ID
    }

    override fun hashCode(): Int = id?.hashCode() ?: 0
}