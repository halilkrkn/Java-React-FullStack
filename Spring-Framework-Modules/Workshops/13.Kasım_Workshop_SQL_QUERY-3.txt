86. a.Kaç farklı ülkeye ihracat yapıyorum ?Bu ülkeler hangileri..?
SELECT country FROM customers
WHERE country <> 'USA'
GROUP BY country

87. En Pahalı 5 ürün
SELECT product_name, unit_price FROM products
ORDER BY unit_price DESC
LIMIT 5

88. ALFKI CustomerID’sine sahip müşterimin sipariş sayısı..?
select count(order_id) as SiparisSayisi from Orders
where customer_id = 'ALFKI'

89. Ürünlerimin toplam maliyeti
select(od.unit_price * od.quantity) as "Toplam Maliyet" from products p
inner join order_details od on p.product_id=od.product_id

90. Şirketim, şimdiye kadar ne kadar ciro yapmış..?
select sum(od.unit_price * od.quantity) as "Ciro" from products p
inner join order_details od on p.product_id=od.product_id

91. Ortalama Ürün Fiyatım
select avg(unit_price)  as "Ürün Ortalama Fiyatı" from products

92. En Pahalı Ürünün Adı
select unit_price, product_name from products
order by  unit_price desc
limit 1

93. En az kazandıran sipariş 
SELECT order_id, SUM(unit_price * quantity) AS "Toplam sipariş"
FROM order_details
GROUP BY order_id
ORDER BY "Toplam sipariş" ASC
limit 1

94. Müşterilerimin içinde en uzun isimli müşteri
select max(length(company_name)) as "En_Uzun_Isım", company_name from customers
group by company_name
limit 1

95. Çalışanlarımın Ad, Soyad ve Yaşları
select first_name, last_name, (CURRENT_DATE - birth_date)/365 AS "AGE" FROM employees

96. Hangi üründen toplam kaç adet alınmış..?
select product_id, sum(quantity) from order_details
group by product_id

97. Hangi siparişte toplam ne kadar kazanmışım..?
SELECT order_id, SUM(unit_price * quantity) AS "Toplam_Kazanc"
FROM order_details
GROUP BY order_id

98. Hangi kategoride toplam kaç adet ürün bulunuyor..?
select c.category_name,c.category_id, count(*) from products p
inner join categories c on p.category_id=c.category_id
group by c.category_id,c.category_name

99. 1000 Adetten fazla satılan ürünler?
select product_name,SUM(quantity) as "Toplam Sipariş Miktarı" from order_details od
inner join products p on od.product_id = p.product_id
group by product_name
having sum(quantity)>1000

100. Hangi Müşterilerim hiç sipariş vermemiş..?
SELECT company_name FROM customers
WHERE customer_id NOT IN (SELECT DISTINCT customer_id FROM orders)

SELECT * FROM customers
LEFT JOIN orders ON customers.customer_id = orders.customer_id
WHERE order_id IS NULL

101. Hangi tedarikçi hangi ürünü sağlıyor ?
select s.supplier_id,s.company_name,p.product_id,p.product_name from products p
join suppliers s on p.supplier_id=s.supplier_id

102. Hangi sipariş hangi kargo şirketi ile ne zaman gönderilmiş..?
select orders.order_id,shippers.company_name,orders.order_date from orders
inner join shippers on orders.ship_via = shippers.shipper_id

103. Hangi siparişi hangi müşteri verir..?
select order_id, customer_id from orders

104. Hangi çalışan, toplam kaç sipariş almış..?
select count(order_id), employee_id from orders
group by employee_id 

105. En fazla siparişi kim almış..?
select count(order_id) as "Siparis_Sayisi", employee_id from orders
group by employee_id 
order by "Siparis_Sayisi" desc
limit 1

106. Hangi siparişi, hangi çalışan, hangi müşteri vermiştir..?
select o.order_id, o.customer_id, (e.first_name ||' '|| e.last_name) as "Ad_Soyad" from orders o
inner join employees e on o.employee_id=e.employee_id

107. Hangi ürün, hangi kategoride bulunmaktadır..? Bu ürünü kim tedarik etmektedir..?
select p.product_name,c.category_name,s.company_name from products p
inner join categories c on p.category_id=c.category_id
inner join suppliers s on p.supplier_id=s.supplier_id

108. Hangi siparişi hangi müşteri vermiş, hangi çalışan almış, hangi tarihte, hangi kargo şirketi tarafından gönderilmiş hangi üründen kaç adet alınmış, hangi fiyattan alınmış, ürün hangi kategorideymiş bu ürünü hangi tedarikçi sağlamış
SELECT o.order_id, customer_id, employee_id, shipped_date, ship_via, od.quantity, od.unit_price, p.category_id, p.supplier_id FROM orders o
INNER JOIN order_details od ON o.order_id = o.order_id
INNER JOIN products p ON od.product_id = p.product_id 

109. Altında ürün bulunmayan kategoriler
select c.category_id, c.category_name from categories c
left join products p on c.category_id = p.category_id
where p.product_id is NULL

110. Manager ünvanına sahip tüm müşterileri listeleyiniz.
select * from customers
where contact_title like '%Manager%'

111. FR ile başlayan 5 karekter olan tüm müşterileri listeleyiniz.
select * from customers
where left(customer_id, 2) = 'FR' and length(customer_id) = 5 
 
112. (171) alan kodlu telefon numarasına sahip müşterileri listeleyiniz.
select * from customers 
where phone like '%(171)%'

113. BirimdekiMiktar alanında boxes geçen tüm ürünleri listeleyiniz.
select * from products
where quantity_per_unit like '%boxes%'

114. Fransa ve Almanyadaki (France,Germany) Müdürlerin (Manager) Adını ve Telefonunu listeleyiniz.(MusteriAdi,Telefon)
select country, phone,contact_title, contact_name as "Mudurler" from customers
where country in ('France', 'Germany') and contact_title like '%Manager%' 

115. En yüksek birim fiyata sahip 10 ürünü listeleyiniz.
select unit_price from products
order by unit_price desc
limit 10

116. Müşterileri ülke ve şehir bilgisine göre sıralayıp listeleyiniz.
select contact_name,country, city from customers
order by country, city

117. Personellerin ad,soyad ve yaş bilgilerini listeleyiniz.
select first_name, last_name, (current_date - birth_date)/365 as "AGE" from employees

118. 35 gün içinde sevk edilmeyen satışları listeleyiniz.
select order_id from orders
where (shipped_date - order_date) > 35

119. Birim fiyatı en yüksek olan ürünün kategori adını listeleyiniz. (Alt Sorgu) 
select category_name from categories
where category_id = (select category_id from products 
             order by unit_price desc limit 1)

120. Kategori adında 'on' geçen kategorilerin ürünlerini listeleyiniz. (Alt Sorgu)
select * from products 
where category_id in(select category_id from categories where category_name like '%on%')

121. Konbu adlı üründen kaç adet satılmıştır.
select sum(quantity),product_name from order_details
inner join products on order_details.product_id=products.product_id
group by product_name
having product_name like '%Konbu%'

122. Japonyadan kaç farklı ürün tedarik edilmektedir.
select count(distinct product_id), suppliers.country from products
inner join suppliers on products.supplier_id=suppliers.supplier_id
group by suppliers.country
having suppliers.country='Japan'

123. 1997 yılında yapılmış satışların en yüksek, en düşük ve ortalama nakliye ücretlisi ne kadardır?
select min (freight) as "Dusuk", max(freight) as "Yuksek", avg(freight) as "Ortalama" from orders
where extract(year from order_date)= 1997

124. Faks numarası olan tüm müşterileri listeleyiniz.
select * from customers
where fax is not NULL

125. 1996-07-16 ile 1996-07-30 arasında sevk edilen satışları listeleyiniz.
select * from orders
where shipped_date between '1996-07-16' and '1996-07-30'