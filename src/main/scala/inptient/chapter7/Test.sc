import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

for {
  resA <- Future { Thread.sleep(1000); println(Thread.currentThread().getName);  2 }
  resB <- Future { Thread.sleep(1000); println(Thread.currentThread().getName); 40 }
} yield ( println(Thread.currentThread().getName))
