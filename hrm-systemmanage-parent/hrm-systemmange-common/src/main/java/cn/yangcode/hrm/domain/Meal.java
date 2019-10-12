package cn.yangcode.hrm.domain;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wenyang
 * @since 2019-09-26
 */
@TableName("t_meal")
public class Meal extends Model<Meal> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 套餐名称
     */
    private String mealName;
    /**
     * 套餐价格
     */
    private BigDecimal mealPrice;
    /**
     * 套餐状态，0正常，1禁用
     */
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public BigDecimal getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(BigDecimal mealPrice) {
        this.mealPrice = mealPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Meal{" +
        ", id=" + id +
        ", mealName=" + mealName +
        ", mealPrice=" + mealPrice +
        ", status=" + status +
        "}";
    }
}
