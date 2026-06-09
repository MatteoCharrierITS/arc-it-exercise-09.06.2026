# Esercitazione

Breve descrizione del progetto: specifica la struttura dati e le viste principali.

## Struttura del progetto
- be/ — backend
- fe/ — frontend

## Database
### Tabella `utenti`
| Campo | Note |
| --- | --- |
| id | Primary key |
| ip | Indirizzo IP dell'utente |

### Tabella `partite`
| Campo | Note |
| --- | --- |
| id | Primary key |
| stato | Stato della partita |
| turno | Turno corrente |

### Tabella `giocate`
| Campo | Note |
| --- | --- |
| id | Primary key |
| id_utente | Riferimento a `utenti.id` |
| id_partita | Riferimento a `partite.id` |
| turno | Turno in cui è stata effettuata la giocata |
| mossa | Descrizione della mossa |

## Viste
- `giocatori.html`
  - Lista giocatori
  - Pulsante "Aggiungi" (inserisce IP)
  - Pulsante "Elimina" (rimuove il player)

## Avvio e utilizzo
Consulta le cartelle `be/` e `fe/` per le istruzioni di avvio specifiche. Ogni sotto-progetto dovrebbe contenere il proprio README con comandi di setup e avvio.

## Contribuire
- Apri una issue per discutere modifiche
- Invia una pull request con descrizione dei cambiamenti

## Links Utili
[Front-End_Documentation](/fe/fe.md)
[Back-End_Documentation](/be/be.md)



