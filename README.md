# 🛒 Cart & Order Management API

Sistema de gerenciamento de carrinho e pedidos desenvolvido para simular o funcionamento básico de um e-commerce backend.

O projeto permite que usuários adicionem produtos ao carrinho, gerenciem itens e realizem pedidos.

O sistema foi projetado seguindo princípios de modelagem orientada a domínio (DDD) e boas práticas de APIs REST.

## 📌 Funcionalidades

👤 Cadastro de usuários  
🛍️ Gerenciamento de produtos  
🛒 Criação e gerenciamento de carrinho  
➕ Adição de produtos ao carrinho  
🔢 Controle de quantidade de itens  
💰 Cálculo automático do valor total do carrinho  
📦 Criação de pedidos  
📊 Controle de status do pedido  
📉 Controle de estoque  

## 🏗️ Modelagem do Sistema

A estrutura do sistema foi modelada utilizando UML, conforme o diagrama abaixo:

<img width="2108" height="2180" alt="image" src="https://github.com/user-attachments/assets/c5d1b102-49d8-4483-acc4-031c535fbdb0" />


## 🔄 Fluxo do Sistema

- 1️⃣ Usuário é criado
- 2️⃣ Usuário possui um Cart
- 3️⃣ Produtos são adicionados ao CartItem
- 4️⃣ O Cart calcula o valor total
- 5️⃣ O usuário finaliza a compra
- 6️⃣ Um Order é criado com os dados do carrinho

## 🧮 Regras de Negócio

O preço do produto é copiado para priceAtMoment no momento da adição ao carrinho.
O total do carrinho é calculado pela soma dos subtotais dos itens.
O estoque do produto deve ser verificado antes de adicionar ao carrinho.
Um pedido pode mudar de status conforme o fluxo de pagamento.

## 📊 Diagrama UML

O sistema foi modelado conforme o seguinte diagrama:

- User → Cart (1:1)
- Cart → CartItem (1:N)
- Product → CartItem (1:N)
- User → Order (1:N)

## 🚀 Possíveis Melhorias

- Implementar pagamento integrado
- Implementar promoções / cupons
- Criar sistema de categorias de produtos
- Implementar cache de produtos
- Adicionar autenticação JWT


## 📚 Objetivo do Projeto

Este projeto foi desenvolvido com foco em:

- Prática de modelagem de domínio
- Estruturação de APIs REST
- Implementação de regras de negócio de e-commerce
- Prática de arquitetura backend.
