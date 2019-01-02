package oriana

import io.prometheus.client.{Counter, Gauge}

trait Monitor {
  def executeTimeout(): Unit

  def operationPending(): Unit
  def operationSucceeded(): Unit
  def operationRetry(): Unit
  def operationFailed(): Unit
}

object NopMonitor extends Monitor {
  override def executeTimeout(): Unit = ()
  override def operationPending(): Unit = ()
  override def operationSucceeded(): Unit = ()
  override def operationRetry(): Unit = ()
  override def operationFailed(): Unit = ()
}

object PrometheusMonitor extends Monitor {
  private val pending = Gauge.build("oriana.pending", "Number of currently pending operations").create()
  private val timeouts = Counter.build("oriana.timeout", "Timeouts encountered in execute* family functions").create()

  private val retries = Counter.build("oriana.retry", "Retries attempted for db transactions").create()
  private val success = Counter.build("oriana.success", "Successful DB operations").create()
  private val failure = Counter.build("oriana.success", "Failed DB operations").create()

  override def executeTimeout(): Unit = timeouts.inc()

  override def operationPending(): Unit = pending.inc()

  override def operationSucceeded(): Unit = {
    pending.dec()
    success.inc()
  }

  override def operationRetry(): Unit = retries.inc()

  override def operationFailed(): Unit = {
    pending.dec()
    failure.inc()
  }
}