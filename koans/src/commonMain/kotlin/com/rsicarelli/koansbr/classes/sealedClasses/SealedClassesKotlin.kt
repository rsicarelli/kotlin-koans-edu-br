/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2014-2019 JetBrains s.r.o.
 * Copyright (c) 2023-2023 Rodrigo Sicarelli
 */

package com.rsicarelli.koansbr.classes.sealedClasses

fun eval(expr: Expr): Int =
    when (expr) {
        is Num -> expr.value
        is Sum -> eval(expr.left) + eval(expr.right)
    }

sealed interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

sealed class StatusPedido(open val id: Int) {

    fun isActive(): Boolean = when (this) {
        is AguardandoPagamento, is Enviado, is Processando -> true
        is Cancelado, is Entregue -> false
    }

    data class AguardandoPagamento(override val id: Int) : StatusPedido(id)
    data class Processando(override val id: Int, val dataEstimadaProcessamento: String) : StatusPedido(id)
    data class Enviado(override val id: Int, val dataEstimadaEntrega: String, val codigoRastreamento: String) : StatusPedido(id)
    data class Entregue(override val id: Int, val dataEntrega: String) : StatusPedido(id)
    data class Cancelado(override val id: Int, val razao: String) : StatusPedido(id)
}
