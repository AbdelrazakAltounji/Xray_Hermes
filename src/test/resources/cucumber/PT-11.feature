

Feature: Naviguer sur sit Hermes


		
			@TEST_PT-11
			Scenario: Naviguer sur site Hermes
				Feature: Naviguer sur un site web
				 Test a realiser pour naviguer sur un site web
				 
				  #Example: premier test
				    Given Que je suis sur le site 
						And Que je saisisse mes identifiants et que je me connecte
						And Dans le menu M3 je navigue vers la page de tableau de valeur
						And Je rentre les valeurs TpA = <valeur1> et Code article = <valeur2>
						And Que je rentre dans le nouvel onglet, et que je tappe PMS170 et je clique sur le bouton OK			
						And Que je rentre dans le champ produit : je colle la valeur2 et appuie sur le bouton Suivant
						And Que je rempli les trois champs: numero programme <valeur4> , date de fin et quantite planifiee <valeur3> et je verifie les informations
						And Dans la liste deroulante Ordre de tri, je selectionne <valeur5>
						And Je verifie que mon numero de programme est <valeur4>
		
					Examples:
					
					| valeur1 |     valeur2    | valeur3 |  valeur4 | valeur5        					 | valeur6 |
					|  "B01"   | "Y3003-Y01-012" |      "55" |   "125706" | "1-Resp/Whse/Prod" |"123458" |
				#	|  "B01"   | "Y3003-Y01-012" |      "55" |   "125707" | "1-Resp/Whse/Prod" | "1234"  |
					 
