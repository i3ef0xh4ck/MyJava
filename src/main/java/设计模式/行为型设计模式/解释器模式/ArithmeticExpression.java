package 设计模式.行为型设计模式.解释器模式;


//算数表达式（非终结符表达式，对应arithmetic , 对于每一个推导式都要生成一个非终结符表达式类）
public class ArithmeticExpression implements Expression {

  public void interpreter(Context context) {
      context.setResult(getResult(context));//计算结果
      context.getOperateNumbers().clear();//清空操作数
      context.setLeftOperateNumber(context.getResult());//将结果压入左操作数
  }

  private int getResult(Context context){
      int result = 0;
      switch (context.getOperator()) {
      case '+':
          result = context.getOperateNumbers().get(0) + context.getOperateNumbers().get(1);
          break;
      case '-':
          result = context.getOperateNumbers().get(0) - context.getOperateNumbers().get(1);
          break;
      default:
          break;
      }
      return result;
  }
  
}
